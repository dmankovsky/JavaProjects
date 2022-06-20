package com.restapi.restapi.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import javax.xml.transform.Source;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationNotFoundException extends RuntimeException implements GraphQLError {
    // creates a custom exception; extend runtime, then make is specific to GraphQL
    // GraphQL error provides a field called extensions, which allows you to pass additional data to the error object that is send back to the client
    // In this case - id of the invalid location is passed (line 17)

    private Map<String, Object> extensions = new HashMap<>();

    public LocationNotFoundException(String message, Long invalidLocationId){
        super(message);
        extensions.put("invalidLocationId", invalidLocationId);
    }
    // custom message "location not found" will be sent to client, with id of that specific location

    @Override
    public List<SourceLocation> getLocations(){return null;}

    @Override
    public Map<String, Object> getExtensions(){return extensions;}

    @Override
    public ErrorType getErrorType(){return ErrorType.DataFetchingException;}
}
