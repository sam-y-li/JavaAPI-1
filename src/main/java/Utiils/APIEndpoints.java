package Utiils;

public enum APIEndpoints {

    //Users
    listUsers("users"),
    showUser("users/{id}"),
    createUser("users"),
    updateUser("users/{id}"),
    deleteUser("users/{id}"),
    searchVulnerabilities("vulnerabilities/search/");

    private final String resource;

    APIEndpoints(String resource)
    {
        this.resource=resource;
    }

    public String getResource()
    {
        return resource;
    }

}
