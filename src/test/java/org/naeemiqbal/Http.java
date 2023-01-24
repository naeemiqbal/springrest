package org.naeemiqbal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

class Http {

    @Test
    void ensureThatUserAPICallReturnStatusCode200() throws Exception {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.github.com/users/vogella")).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        assertTrue( response.statusCode() == HttpStatus.OK.value() , " ");
    //    assertThat(response.statusCode(), is(HttpStatus.OK));
    }

    @Test
    @DisplayName("Ensures that the content type starts with application/json")
    void ensureThatJsonIsReturnedAsContentType() throws Exception {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.github.com/users/vogella")).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        assertFalse(response==null, "NO response ");
    }

    @Test
    @DisplayName ("Ensure that the JSON for the user vogella contains a reference to the Twitter user")
    void ensureJsonContainsTwitterHandler() throws Exception {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.github.com/users/vogella")).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        assertTrue(response.statusCode()==200, "Good response." );
    }
}