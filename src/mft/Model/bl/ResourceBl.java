package mft.Model.bl;

import mft.Model.da.ResourceDa;
import mft.Model.entity.Resource;

import java.util.ArrayList;
import java.util.List;

public class ResourceBl {

    public static void save(Resource resource) throws Exception {

        try(ResourceDa resourceDa = new ResourceDa()){
            resourceDa.save(resource);
        }
    }

    public static void delete(Resource resource) throws Exception {
        try(ResourceDa resourceDa = new ResourceDa()){
            resourceDa.delete(resource);
        }
    }

    public static void update(Resource resource) throws Exception {
        try(ResourceDa resourceDa = new ResourceDa()){
            resourceDa.update(resource);
        }
    }

    public static Resource getResource(int resourceId) throws Exception {
        Resource resource = new Resource();
        try(ResourceDa resourceDa = new ResourceDa()){
            resource = resourceDa.getResource(resourceId).get();
        }
        return resource;
    }

    public static List<Resource> getBooksByTitle(String resourceTitle) throws Exception {
        List<Resource> books = new ArrayList<>();
        try(ResourceDa bookDa = new ResourceDa()){
            books = bookDa.getResourcesByTitle(resourceTitle);
        }
        return books;
    };



    public static List<Resource>  getAllResources() throws Exception {
        List<Resource> resources = new ArrayList<>();

        try(ResourceDa resourceDa = new ResourceDa()){
            resources = resourceDa.getAllResources();
        }
//        List<Optional<Book>> optionalBooks  = books.stream()
//                .map((o) -> Optional.of(o)).collect(Collectors.toList());

        return resources;
    }

}
