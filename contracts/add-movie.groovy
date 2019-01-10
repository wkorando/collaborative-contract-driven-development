import org.springframework.cloud.contract.spec.Contract
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

Contract.make {
    request {
        method 'POST'
        url '/api/v1/movies'
        body([ 
    		movieName: "Predator",
    		genre: "Action",
    		releaseYear: 1989
    		runtime: 107   
		])
		headers { 
			header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
		}
    }
    response {
        status 201
		headers { 
			header(HttpHeaders.LOCATION, '/api/v1/movies/1'
				   HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
		}
    }
}