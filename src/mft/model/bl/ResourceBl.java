package mft.model.bl;

import mft.model.da.ResourceDa;
import mft.model.entity.Resource;
import mft.model.entity.ResourceType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<Resource> resource = Optional.of(new Resource());
        ResourceDa resourceDa = new ResourceDa();
        resource = resourceDa.getResourceById(resourceId);

        return resource.get();
    }

    public static Resource getResourcesByISBN(Integer ISBN) throws SQLException {
        Optional<Resource> resource = Optional.of(new Resource());
        ResourceDa resourceDa = new ResourceDa();
        resource = resourceDa.getResourcesByISBN(ISBN);
        return resource.get();
    }

    public static List<Resource> getResourceByTitle(String resourceTitle) throws Exception {
        List<Resource> resources = new ArrayList<>();
        ResourceDa resourceDa = new ResourceDa();
        resources = resourceDa.getResourcesByTitle(resourceTitle);

        return resources;
    };
    public static List<Resource> getResourcesByResourceType(ResourceType resourceType) throws SQLException {
        List<Resource> resources = new ArrayList<>();
        ResourceDa resourceDa = new ResourceDa();
        resources = resourceDa.getResourcesByResourceType(resourceType);
        return resources;
    }

    public static List<Resource> getResourcesByAuthor(String author) throws SQLException {
        List<Resource> resources = new ArrayList<>();
        ResourceDa resourceDa = new ResourceDa();
        resources = resourceDa.getResourcesByAuthor(author);
        return resources;
    }

    public static List<Resource> getResourcesByPublisher(String publisher) throws SQLException {
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

    public static List<Resource> getAllResources() throws SQLException {
        List<Resource> resources = new ArrayList<>();
        ResourceDa resourceDa = new ResourceDa();
        resources = resourceDa.getAllResources();
        return resources;
    }


}
