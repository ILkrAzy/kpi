package org.kpi.springmvctest;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpi.Application;
import org.kpi.model.dto.NewUser;
import org.kpi.model.dto.NewUserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserControllerTest2 {
    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("build/generated-snippets");

    private RestDocumentationResultHandler documentationHandler;
    
    private MockMvc               mockMvc;

    @Autowired
    private WebApplicationContext context;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Before
    public void setUp() {
        this.documentationHandler = document("{method-name}",
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()));
        
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();
    }

    @Test
    public void getAll() throws Exception {
        FieldDescriptor[] user = new FieldDescriptor[] {
                fieldWithPath("username").description("The user's username"),
                fieldWithPath("email").description("The user's email address"),
                fieldWithPath("firstName").description("The user's last name"),
                fieldWithPath("lastName").description("The user's last name"),
                fieldWithPath("role").description("The user's role")};

        this.mockMvc
                .perform(get("/api/users").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(this.documentationHandler.document(
                        responseFields(
                                fieldWithPath("[]").description(
                                        "An array of users")).andWithPrefix(
                                "[].", user)));
    }
    
    @Test
    public void getUser() throws Exception {
        this.mockMvc.perform(get("/api/users/admin").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(this.documentationHandler.document(
                responseFields( 
                        fieldWithPath("username").description("The user's username"), 
                        fieldWithPath("email").description("The user's email"),
                        fieldWithPath("firstName").description("The user's last name"),
                        fieldWithPath("lastName").description("The user's last name"),
                        fieldWithPath("role").description("The user's role")))); 
    }

    @Test
    public void createUser() throws Exception{
        NewUser user = new NewUser("vquochuy", "vquochuy@test.com", "Huy", "Vu", "123456");
        ConstrainedFields fields = new ConstrainedFields(NewUserInput.class);
        this.mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user)))
        .andExpect(status().isOk())
        .andDo(this.documentationHandler.document(
                requestFields(
                    fields.withPath("username").description("The username of the user")
                    .attributes(key("constraints")
                            .value("Must not be null. Must not be empty")),
                    fields.withPath("password").description("The password of the user")
                    .attributes(key("constraints")
                            .value("Must not be null. Must not be empty")),
                    fields.withPath("lastName").description("The lastName of the user"),
                    fields.withPath("email").description("The email of the user"),
                    fields.withPath("firstName").description("The firstName of the user"))));
        
        /*Map<String, String> newPerson = new HashMap<>();
        newPerson.put("username", "vquochuy123");
        newPerson.put("email", "vquochuy@test.com");
        newPerson.put("password", "123456");
        newPerson.put("firstName", "Huy");
        newPerson.put("lastName", "Vu");

        ConstrainedFields fields = new ConstrainedFields(NewUserInput.class);
        NewUser user = new NewUser("vquochuy", "vquochuy@test.com", "Huy", "Vu", "123456");
        this.mockMvc.perform(
                post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user)))
                .andExpect(status().isOk())
                .andDo(document("users", requestFields(
                        fields.withPath("username").description("The username of the user"),
                        fields.withPath("email").description("The email of the user"),
                        fields.withPath("password").description("The password of the user"),
                        fields.withPath("lastName").description("The lastName of the user"),
                        fields.withPath("firstName").description("The firstName of the user"))));*/
    }
    
    private static class ConstrainedFields {

        private final ConstraintDescriptions constraintDescriptions;

        ConstrainedFields(Class<?> input) {
            this.constraintDescriptions = new ConstraintDescriptions(input);
        }

        private FieldDescriptor withPath(String path) {
            return fieldWithPath(path).attributes(key("constraints").value(StringUtils
                    .collectionToDelimitedString(this.constraintDescriptions
                            .descriptionsForProperty(path), ". ")));
        }
    }
    
    /*
     * converts a Java object into JSON representation
     */
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
