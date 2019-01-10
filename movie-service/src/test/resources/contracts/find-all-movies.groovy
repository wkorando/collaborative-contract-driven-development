import org.springframework.cloud.contract.spec.Contract
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

Contract.make {
    request {
        method 'GET'
        url '/api/v1/movies'
		headers { 
			header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
		}
    }
    response {
        status 200
        body([ 
    		"movieName" : "Independence Day",
    		"genre" : "Action",
    		"releaseYear" : 1996,
    		"runtime" : 145   
		])
		headers { 
			header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
		}
    }
}