/**
 * 
 */
package org.naeemiqbal.db.part;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

/**
 * @author Naeem Iqbal
 *
 */

@SpringBootTest
class PartControllerTest {

	private String URL = "https://api.github.com/users/naeemiqbal";//http://localhost:7878/parts";
	/**
	 * Test method for {@link org.naeemiqbal.db.part.PartController#getAll()}.
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test
	void testGetAll(){ 
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL)).build();
        HttpResponse<String> response;
		try {
			response = client.send(request, BodyHandlers.ofString());
	        assertTrue( response.statusCode() == HttpStatus.OK.value() , "Status not OK. ");
		} catch (IOException | InterruptedException e) {
			fail("Failed to test GellAll. " + e.getMessage() );
		}
			
	}

	/**
	 * Test method for {@link org.naeemiqbal.db.part.PartController#getOne(java.lang.Long)}.
	 */
	@Test
	@DisplayName("Test get one. ")
	void testGetOne() {
		genericTest();
	}

	/**
	 * Test method for {@link org.naeemiqbal.db.part.PartController#addpart(org.naeemiqbal.db.part.Part)}.
	 */
	@Test
	void testAddpart() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link org.naeemiqbal.db.part.PartController#updatepart(org.naeemiqbal.db.part.Part, java.lang.Long)}.
	 */
	@Test
	void testUpdatepart() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link org.naeemiqbal.db.part.PartController#deletepart(java.lang.Long)}.
	 */
	@Test
	void testDeletepart() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link org.naeemiqbal.db.part.PartController#patchpart(java.lang.Long, java.util.Map)}.
	 */
	@Test
	void testPatchpart() {
		assertTrue(true);
	}

	
	boolean genericTest()  {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.github.com/users/vogella")).build();
        HttpResponse<String> response;
		try {
			response = client.send(request, BodyHandlers.ofString());
	        assertTrue( response.statusCode() == HttpStatus.OK.value() , "Contacted github ");			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			fail( "An exeption " + e.getStackTrace());			
		}
        return true;
	}
}
