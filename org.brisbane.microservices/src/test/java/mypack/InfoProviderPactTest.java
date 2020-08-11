package mypack;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;


@RunWith(PactRunner.class)
@Provider("infoprovider")
@PactFolder("target\\pacts")

public class InfoProviderPactTest
{
	private static final int WIREMOCK_PORT=9090;
	@BeforeClass
	public static void setup()
	{
		WireMockServer wireMockServer;
		wireMockServer=new WireMockServer(WIREMOCK_PORT);
		wireMockServer.start();
		wireMockServer.stubFor(get(urlEqualTo("/info"))
				.willReturn(aResponse()
				.withStatus(200)
				.withHeader("Content-Type","application/json")
				.withBody("{\"id\":\"11\",\"Fname\":\"kalam\",\"age\":\"78\"}")
				));
				
	}
	
	@TestTarget
	public final Target target =new HttpTarget("http","localhost",WIREMOCK_PORT);
	@State("test GET")
	public void toGetState()
	{
	}
	
	}

	
	
