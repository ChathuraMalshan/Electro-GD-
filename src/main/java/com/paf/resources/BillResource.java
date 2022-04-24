package com.paf.resources;

import com.paf.model.*;
import com.paf.service.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;


@Path("/Billings")
public class BillResource {

	Bill billingObj = new Bill();

	// Read API
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readbillings() {
		BillService billingObj = new BillService();

		return billingObj.readbillings();
	}

	// Insert API
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertbilling(String billingData) {
		JsonObject billingObject = new JsonParser().parse(billingData).getAsJsonObject();

		String AccNumber = billingObject.get("AccNumber").getAsString();
		String Date = billingObject.get("Date").getAsString();
		String Remark = billingObject.get("Remark").getAsString();
		
		BillService billingObject2 = new BillService();

		billingObj.setAccNumber(AccNumber);
		billingObj.setDate(Date);
		billingObj.setRemark(Remark);
		

		String output = billingObject2.insertbilling(billingObj);
		return output;
	}

	// Update API
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatebilling(String billingData) {
		// Convert the input string to a JSON object
		JsonObject billingObject = new JsonParser().parse(billingData).getAsJsonObject();
		// Read the values from the JSON object
		String AccNumber = billingObject.get("AccNumber").getAsString();
		String Date = billingObject.get("Date").getAsString();
		String Remark = billingObject.get("Remark").getAsString();
		
		BillService billingObject1 = new BillService();

		billingObj.setAccNumber(AccNumber);
		billingObj.setDate(Date);
		billingObj.setRemark(Remark);
	
		String output = billingObject1.updatebilling(billingObj);
		return output;
	}

	// Delete API
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletebilling(String billingData) {

		JsonObject billingObject = new JsonParser().parse(billingData).getAsJsonObject();

		String AccNumber = billingObject.get("AccNumber").getAsString();

		BillService billingObject2 = new BillService();
		billingObj.setAccNumber(AccNumber);

		String output = billingObject2.deletebilling(billingObj);
		return output;
	}
	@GET
	@Path("/AccountInfo/")
	@Produces(MediaType.TEXT_PLAIN)
	public String readPaymentInfo() {
	BillService payObj = new BillService();
	return payObj.readPaymentInfo();
	}

	@GET
	@Path("/AccountInfo/{AccNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public String readPaymentAccordingToAccountNo(@PathParam("AccNumber") String AccNumber) {
		BillService payObj = new BillService();
	return payObj.asAccountNo(AccNumber);
	}

}