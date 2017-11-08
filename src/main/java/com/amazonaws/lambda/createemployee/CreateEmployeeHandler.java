package com.amazonaws.lambda.createemployee;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.amazonaws.lambda.createemployee.model.Employee;
import com.amazonaws.lambda.createemployee.model.MyAppResponse;
import com.amazonaws.lambda.createemployee.util.RDSUtil;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateEmployeeHandler implements RequestHandler<Employee, MyAppResponse> {
	private static final StringBuffer sql = new StringBuffer("INSERT INTO EMPLOYEES ")
			.append(" (EMP_ID, EMP_NAME, EMAIL )")
			.append(" VALUES (?,?,?)");
	MyAppResponse resp = new MyAppResponse();
	@Override
	public MyAppResponse handleRequest(Employee emp, Context context) {
		try (Connection con = RDSUtil.getRDSConnection()) {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, emp.getEmpId());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getEmail());
			pstmt.executeUpdate();
			
			resp.setMsg("Success");
			resp.setStatusCode(200);
			return resp;
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMsg("Failure");
			resp.setStatusCode(500);
			return resp;
		}
		
	}

}
