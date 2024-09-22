package mft.model.bl;

import mft.model.da.ResourceDa;
import mft.model.entity.Category;
import mft.model.entity.Language;
import mft.model.entity.Resource;
import mft.model.entity.ResourceType;
import mft.model.tools.JdbcProvider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResourceBl {

    public static void save(Resource resource) throws Exception {
        ResourceDa resourceDa = new ResourceDa();
        resourceDa.save(resource);
    }

    public static void update(Resource resource) throws Exception {
        ResourceDa resourceDa = new ResourceDa();
        resourceDa.update(resource);
    }

    public static void delete(Integer ISBN) throws Exception {
        ResourceDa resourceDa = new ResourceDa();
        resourceDa.delete(ISBN);
    }



    public static Resource getResourceById(int resourceId) throws Exception {
        Resource resource = new Resource();
        ResourceDa resourceDa = new ResourceDa();
        resource = resourceDa.getResourceById(resourceId).get();

        return resource;
    }

    public List<Resource> getResourcesByISBN(Integer ISBN) throws SQLException {
        List<Resource> resources = new ArrayList<>();
        ResourceDa resourceDa = new ResourceDa();
        resources = resourceDa.getResourcesByISBN(ISBN);
        return resources;
    }

    public static List<Resource> getBooksByTitle(String resourceTitle) throws Exception {
        List<Resource> books = new ArrayList<>();
        ResourceDa resourceDa = new ResourceDa();
        books = resourceDa.getResourcesByTitle(resourceTitle);

        return books;
    };
    public List<Resource> getResourcesByResourceType(ResourceType resourceType) throws SQLException {
        List<Resource> resources = new ArrayList<>();
        ResourceDa resourceDa = new ResourceDa();
        resources = resourceDa.getResourcesByResourceType(resourceType);
        return resources;
    }

    public List<Resource> getResourcesByAuthor(String author) throws SQLException {
        List<Resource> resources = new ArrayList<>();
        ResourceDa resourceDa = new ResourceDa();
        resources = resourceDa.getResourcesByAuthor(author);
        return resources;
    }

    public List<Resource> getResourcesByPublisher(String publisher) throws SQLException {
        List<Resource> resources = new ArrayList<>();
        ResourceDa resourceDa = new ResourceDa();
        resources = resourceDa.getResourcesByPublisher(publisher);
        return resources;
    }

    public List<Resource> getResourcesByCategory(String category) throws SQLException {
        List<Resource> resources = new ArrayList<>();
        ResourceDa resourceDa = new ResourceDa();
        resources = resourceDa.getResourcesByCategory(category);
        return resources;
    }

    public List<Resource> getAllResources() throws SQLException {
        List<Resource> resources = new ArrayList<>();
        ResourceDa resourceDa = new ResourceDa();
        resources = resourceDa.getAllResources();
        return resources;
    }


}
