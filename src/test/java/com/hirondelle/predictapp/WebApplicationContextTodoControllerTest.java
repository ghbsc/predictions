package com.hirondelle.predictapp;

import java.util.Arrays;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.hirondelle.predictapp.domain.model.PredictionList;
import com.hirondelle.predictapp.domain.service.IPredictionListService;

import static org.mockito.Mockito.when;
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
    private WebApplicationContext webApplicationContext;    
    
    @Before
    public void setUp() {
        //We have to reset our mock between tests because the mock objects
        //are managed by the Spring container. If we would not reset them,
        //stubbing and verified behavior would "leak" from one test to another.
        Mockito.reset(predictionListServiceMock);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
    @Test
    public void predictionlist_list_ShouldAddToModelAndRenderListView() throws Exception {
    	PredictionList first = new PredictionList();
    	first.setId(1);
    	first.setTitle("first");
    	first.setCreationDate(new Date());
    	
    	PredictionList second = new PredictionList();
    	second.setId(2);
    	second.setTitle("second");
    	second.setCreationDate(new Date());
    	
    	when(predictionListServiceMock.findByUserID(0)).thenReturn(Arrays.asList(first, second));
    	
    	mockMvc.perform(get("/predictionlist/list"))
    		.andExpect(status().isOk())
    		.andExpect(view().name("lists/list"));
    		//.andExpect(forwardedUrl(expectedUrl));
    }
    
}
