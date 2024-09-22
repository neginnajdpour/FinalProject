package mft.model.bl;

import mft.model.da.ResourceDa;
import mft.model.entity.Resource;

import java.util.ArrayList;
import java.util.List;

public class ResourceBl {

    public static void save(Resource resource) throws Exception {
        ResourceDa resourceDa = new ResourceDa();
        resourceDa.save(resource);
    }

    public static void delete(Integer ISBN) throws Exception {
        ResourceDa resourceDa = new ResourceDa();
        resourceDa.delete(ISBN);
    }

    public static void update(Resource resource) throws Exception {
        ResourceDa resourceDa = new ResourceDa();
        resourceDa.update(resource);
    }

    public static Resource getResourceById(int resourceId) throws Exception {
        Resource resource = new Resource();
        ResourceDa resourceDa = new ResourceDa();
        resource = resourceDa.getResourceById(resourceId).get();

        return resource;
    }

    public static List<Resource> getBooksByTitle(String resourceTitle) throws Exception {
        List<Resource> books = new ArrayList<>();
        ResourceDa resourceDa = new ResourceDa();
        books = resourceDa.getResourcesByTitle(resourceTitle);

        return books;
    };



    public static List<Resource>  getAllResources() throws Exception {
        List<Resource> resources = new ArrayList<>();
        ResourceDa resourceDa = new ResourceDa();
        resources = resourceDa.getAllResources();

//        List<Optional<Book>> optionalBooks  = books.stream()
//                .map((o) -> Optional.of(o)).collect(Collectors.toList());

        return resources;
    }

}
