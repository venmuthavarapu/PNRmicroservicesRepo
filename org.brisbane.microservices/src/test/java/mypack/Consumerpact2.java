
				package mypack;
				import java.util.HashMap;
				import java.util.Map;

				import org.junit.Rule;
				import org.junit.Test;
				import org.springframework.web.client.RestTemplate;

				import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
				import au.com.dius.pact.consumer.junit.PactVerification;
				import au.com.dius.pact.core.model.annotations.Pact;
				import au.com.dius.pact.model.RequestResponsePact;
				import org.springframework.http.ResponseEntity;
				import au.com.dius.pact.consumer.PactProviderRuleMk2;

				public class Consumerpact2
				{
					@Rule
					public PactProviderRuleMk2 mkprovider=new PactProviderRuleMk2("infoprovider","localhost",9090,this);
					@Pact(consumer="consumer_B") public RequestResponsePact createPact(PactDslWithProvider builder)
					
					{
						System.out.println(mkprovider);
						Map<String,String> headers=new HashMap<>();
						headers.put("Content-Type","application/json");
						return(builder.given("test GET")
								.uponReceiving("GET REQUEST")
								.path("/info").method("GET")
								.willRespondWith()
								.status(200)
								.headers(headers)
								.body("{\"id\":\"11\",\"age\":\"78\"}")
								.toPact());
					}
					@Test
					@PactVerification
					public void testconsumercontracta()
					{
						RestTemplate rt=new RestTemplate();
						ResponseEntity<String> res=rt.getForEntity(mkprovider.getUrl()+"/info",String.class);
						System.out.println(res.getStatusCode().value());
						System.out.println(res.getHeaders().get("content-Type"));
						System.out.println(res.getBody());
					}
					}
					
