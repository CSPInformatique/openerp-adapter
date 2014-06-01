package com.cspinformatique.openerp.adapter;

import java.util.HashMap;
import java.util.Map;

import com.cspinformatique.openerp.entity.Partner;
import com.debortoliwines.openerp.api.FilterCollection;
import com.debortoliwines.openerp.api.Row;
import com.debortoliwines.openerp.api.RowCollection;

public class PartnerAdapter {
	private OpenERPAdapter openERPAdapter;
	
	public PartnerAdapter(OpenERPAdapter openERPAdapter){
		this.openERPAdapter = openERPAdapter;
	}
	
	public Row getPartnerRow(String email){
		FilterCollection filters = new FilterCollection();
		filters.add("email","=",email);
		
		RowCollection rows =	this.openERPAdapter.searchAndReadObject(
									filters, 
									new String[]{"customer", "name", "email", "street", "street2", "zip", "phone"}, 
									Partner.OPENERP_KEY
								);
		
		if(rows.size() == 0){
			return null;
		}else if(rows.size() == 1){
			return rows.get(0);
		}else{
			throw new RuntimeException("Multiple partners for email " + email);
		}
	}
	
	private Map<String, Object> transcodePartnerToParameters(Partner partner){
		HashMap<String, Object> partnerMap = new HashMap<String, Object>();
		
		partnerMap.put("customer", partner.isCustomer());
		partnerMap.put("email", partner.getEmail());
		partnerMap.put("name", partner.getName());
		partnerMap.put("street", partner.getStreet());
		partnerMap.put("street2", partner.getStreet2());
		partnerMap.put("zip", partner.getZip());
		partnerMap.put("phone", partner.getPhone());
		
		return partnerMap;
	} 
	
	public void save(Partner partner){
		Row partnerRow = this.getPartnerRow(partner.getEmail()); 
		
		if(partnerRow == null){
			this.openERPAdapter.createObject(this.transcodePartnerToParameters(partner), Partner.OPENERP_KEY);
		}else{
			this.openERPAdapter.updateObject(
				this.openERPAdapter.updateParameters(partnerRow, this.transcodePartnerToParameters(partner)), 
				Partner.OPENERP_KEY
			);
		}
	}	
}
