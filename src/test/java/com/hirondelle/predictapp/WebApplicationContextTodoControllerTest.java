package com.hirondelle.predictapp;

import java.util.Arrays;
import java.util.Date;

import org.hamcrest.beans.HasProperty;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.hirondelle.predictapp.domain.model.CustomUser;
import com.hirondelle.predictapp.domain.model.PredictionList;
import com.hirondelle.predictapp.domain.service.IAuthenticationFacade;
import com.hirondelle.predictapp.domain.service.IPredictionListService;





//import static org.hamcrest.Matchers.allOf;
//import static org.hamcrest.Matchers.hasItem;
//import static org.hamcrest.Matchers.hasProperty;
//import static org.hamcrest.Matchers.hasSize;
//import static org.hamcrest.Matchers.is;
//import static org.hamcrest.Matchers.isEmptyOrNullString;
//import static org.hamcrest.Matchers.nullValue;
//import static org.mockito.Matchers.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
(
  {
   "classpath:TestContext.xml"
//   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
//   "/META-INF/persistence-postgresql.properties",   
//   "/META-INF/persistence.xml",
//   "/META-INF/predict-infra.xml",
//   "/META-INF/dozer/predictionList-mapping.xml",   
  }
)
@WebAppConfiguration
public class WebApplicationContextTodoControllerTest {
	
    private MockMvc mockMvc;
    
    @Autowired
    private IPredictionListService predictionListServiceMock;
  
    @Autowired
    private IAuthenticationFacade authenticationFacadeMock;
    
    @Autowired
    private WebApplicationContext webApplicationContext;    
    
    @Before
    public void setUp() {
        //We have to reset our mock between tests because the mock objects
        //are managed by the Spring container. If we would not reset them,
        //stubbing and verified behavior would "leak" from one test to another.
        Mockito.reset(predictionListServiceMock);
        Mockito.reset(authenticationFacadeMock);
        
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
    @Test
    public void predictionlist_list_ShouldAddToModelAndRenderListView() throws Exception {
    	PredictionList first = new PredictionList();
    	first.setId(1);
    	first.setTitle("first");
    	
    	PredictionList second = new PredictionList();
    	second.setId(2);
    	second.setTitle("second");
    	
    	CustomUser user = new CustomUser("screen011","", false, false, false, false, AuthorityUtils.createAuthorityList("ROLE_USER"), 1);
    	//TestingAuthenticationToken testingAuthenticationToken = new TestingAuthenticationToken(user, null);
    	
    	when(authenticationFacadeMock.getPrincipal()).thenReturn(user);
    	//when(predictionListServiceMock.findByUserID(org.mockito.Matchers.any(Integer.class))).thenReturn(Arrays.asList(first, second));
    	when(predictionListServiceMock.findByUserID(user.getUserID())).thenReturn(Arrays.asList(first, second));
    	
    	mockMvc.perform(get("/predictionlist/list"))
    		//.principal(testingAuthenticationToken))
    		.andExpect(status().isOk())
    		.andExpect(view().name("lists/list"))
    		.andExpect(forwardedUrl("/WEB-INF/views/lists/list.jsp"))
    		.andExpect(model().attribute("predictionLists", hasSize(2)))
    		.andExpect(model().attribute("predictionLists", hasItem(
    				allOf(
    						hasProperty("id", is(1)),
    						hasProperty("title", is("first"))   						
						)
			)))
			    		.andExpect(model().attribute("predictionLists", hasItem(
    				allOf(
    						hasProperty("id", is(2)),
    						hasProperty("title", is("second"))   						
						)
			)));
    	
    	verify(predictionListServiceMock, times(1)).findByUserID(org.mockito.Matchers.any(Integer.class));
    	verifyNoMoreInteractions(predictionListServiceMock);
    }
    
}
