package com.Test3;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Storage")
public class StroageService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/createLUN")
	public String createLUN(){
		Storage s = Storage.getInstance();
		String LUNNunber = s.allocate();
		return "allocate storage unit to LUN succeed. LUNNumber is " + LUNNunber;
	}
	
	@GET
	@Path("removeLUN/{LUNNumber}")
	@Produces(MediaType.TEXT_PLAIN)
	public String removeLUN(@PathParam("LUNNumber") String LUNNumber){
		Storage s = Storage.getInstance();
		String msg = s.remove(LUNNumber);
		return msg;
	}
	
	@GET
	@Path("/getStorageInfo")
	@Produces(MediaType.TEXT_PLAIN)
	public String getStorageInfo(){
		Storage s = Storage.getInstance();
		return s.getStorageInfo();
	}

}
