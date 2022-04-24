package com.paf.resources;

import com.paf.model.*;
import com.paf.service.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;

@Path("/Suppliers")
public class SupplierResource {

	Supplier supObj = new Supplier();

	// Read API
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readsuppliers() {
		SupplierService supObj = new SupplierService();

		return supObj.readsuppliers();
	}

	// Insert API
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertsupplier(String supData) {
		JsonObject supObject = new JsonParser().parse(supData).getAsJsonObject();

		String AccNumber = supObject.get("AccNumber").getAsString();
		Float Units = supObject.get("Units").getAsFloat();
		Float UnitPrice = supObject.get("UnitPrice").getAsFloat();
		String StartDate = supObject.get("StartDate").getAsString();
		String EndDate = supObject.get("EndDate").getAsString();

		SupplierService supObject2 = new SupplierService();

		supObj.setAccNumber(AccNumber);
		supObj.setUnits(Units);
		supObj.setUnitPrice(UnitPrice);
		supObj.setStartDate(StartDate);
		supObj.setEndDate(EndDate);

		String output = supObject2.insertsupplier(supObj);
		return output;
	}

	// Update API
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatesupplier(String supplierData) {
		// Convert the input string to a JSON object
		JsonObject supObject = new JsonParser().parse(supplierData).getAsJsonObject();
		// Read the values from the JSON object
		String AccNumber = supObject.get("AccNumber").getAsString();
		Float Units = supObject.get("Units").getAsFloat();
		Float UnitPrice = supObject.get("UnitPrice").getAsFloat();
		String StartDate = supObject.get("StartDate").getAsString();
		String EndDate = supObject.get("EndDate").getAsString();

		SupplierService supObject1 = new SupplierService();

		supObj.setAccNumber(AccNumber);
		supObj.setUnits(Units);
		supObj.setUnitPrice(UnitPrice);
		supObj.setStartDate(StartDate);
		supObj.setEndDate(EndDate);

		String output = supObject1.updatesupplier(supObj);
		return output;
	}

	// Delete API
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletesup(String supplierData) {

		JsonObject supObject = new JsonParser().parse(supplierData).getAsJsonObject();

		String AccNumber = supObject.get("AccNumber").getAsString();

		SupplierService supObject2 = new SupplierService();
		supObj.setAccNumber(AccNumber);

		String output = supObject2.deletesupplier(supObj);
		return output;
	}

}