package com.restJersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

@Path("/simple")
public class SimpleRestService {

	private static final Logger logger = Logger.getLogger(SimpleRestService.class);

	@GET
	@Path("/get")
    @Produces(MediaType.TEXT_PLAIN)
	public String getSomething(@QueryParam("whereRequest") String whereRequest ,
			 @QueryParam("selectRequest") String selectRequest ) {
	
	StringBuilder sb= new StringBuilder();
	int temp=0;
	int temp1=0;
	
	if(selectRequest!=null){
		sb.append("select ");
		String arg[]=selectRequest.split(",");
		for(String value:arg){
			++temp;
			sb.append(value);
			if(arg.length!=temp){
				sb.append(",");
			}
		}
		sb.append(" from Employee Where ");
	}	
	if(whereRequest!=null){
			String arg[]=whereRequest.split(",");
			for(String value:arg){
				++temp1;
				sb.append("id="+value);
				if(arg.length!=temp1){
					sb.append(" and ");
				}
			}
		}
        return sb.toString();	
	}
}
