package com.example;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;



@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SpringRestDocApplication.class)
@EnableAutoConfiguration
@WebAppConfiguration
public class ExampleControllerTest {

	@Rule
	public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");
	private RestDocumentationResultHandler document;
	@Autowired
	private WebApplicationContext context;
	@Autowired
	private ObjectMapper objectMapper;

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.document = document("{method-name}");
		mockMvc = MockMvcBuilders.webAppContextSetup(context)
				.apply(documentationConfiguration(this.restDocumentation).uris().withScheme("https"))
				.alwaysDo(this.document).build();
	}

	@Test
	public void getEmployeeDetail() throws Exception {
		this.mockMvc.perform(get("/employees/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andDo(document);
	}
	
//	@Test
//	public void getEmployee1() throws Exception {
//		this.mockMvc.perform(get("/employees?page=1&size=10").accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk())
//		.andDo(document);
//	}

	
	@Test
	public void addEmployee() throws Exception {
		Map<String, String> employee = new HashMap<>();
		employee.put("empId", "2");
		employee.put("empName", "Sathish");
		employee.put("phoneNO", "987654321");
        
        this.mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON).content(
                        this.objectMapper.writeValueAsString(employee))).andExpect(status().isCreated());
        
	}
	
	@Test
	public void updateEmployeeDetail() throws Exception {
	    Map<String, String> empPosting = new HashMap<>();
	    empPosting.put("empName", "Siva");

	    this.mockMvc.perform(
	            patch("/employees/2").contentType(MediaType.APPLICATION_JSON).content(
	                    this.objectMapper.writeValueAsString(empPosting)
	            )
	    ).andExpect(status().isNoContent());
	}
	
	


}

