package mft.model.da;

import mft.model.entity.Category;
import mft.model.entity.Language;
import mft.model.entity.Resource;
import mft.model.entity.ResourceType;
import mft.model.tools.JdbcProvider;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// save, edit, remove, findAll, findById, findByISBN, findByResourceType, findByAUTHOR, findByPublisher, findByCategory
public class ResourceDa implements AutoCloseable {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ResourceDa() {}
    public ResourceDa(Connection connection) {
        this.connection = connection;
    }

    public void save(Resource resource) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("INSERT INTO RESOURCE( ISBN , RESOURCE_TYPE , TITLE , EDITION , AUTHOR , CATEGORY , PUBLISHER , LANGUAGE , QUANTITY , DESCRIPTION) VALUES (?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, resource.getISBN());
        preparedStatement.setString(2, resource.getRESOURCE_TYPE().name());
        preparedStatement.setString(3,resource.getTitle());
        preparedStatement.setString(4, resource.getEDITION());
        preparedStatement.setString(5,resource.getAUTHOR());
        preparedStatement.setString(6, resource.getCATEGORY().name());
        preparedStatement.setString(7, resource.getPUBLISHER());
        preparedStatement.setString(8, resource.getLANGUAGE().name());
        preparedStatement.setInt(9,resource.getQUANTITY());
        preparedStatement.setString(10, resource.getDESCRIPTION());
        preparedStatement.executeUpdate();
    }

    public void delete(Integer ISBN) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("DELETE FROM RESOURCE WHERE ISBN = ?");
        preparedStatement.setInt(1, ISBN);
        preparedStatement.executeUpdate();
    }

    public void update(Resource resource) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("UPDATE RESOURCE SET RESOURCE_TYPE = ? , TITLE = ? , EDITION = ? , AUTHOR = ? , CATEGORY = ? , PUBLISHER = ? , LANGUAGE = ? , QUANTITY = ? , DESCRIPTION = ? WHERE ISBN = ?");
        preparedStatement.setString(1, resource.getRESOURCE_TYPE().name());
        preparedStatement.setString(2,resource.getTitle());
        preparedStatement.setString(3, resource.getEDITION());
        preparedStatement.setString(4,resource.getAUTHOR());
        preparedStatement.setString(5, resource.getCATEGORY().name());
        preparedStatement.setString(6, resource.getPUBLISHER());
        preparedStatement.setString(7, resource.getLANGUAGE().name());
        preparedStatement.setInt(8,resource.getQUANTITY());
        preparedStatement.setString(9, resource.getDESCRIPTION());
        preparedStatement.setInt(10, resource.getISBN());
        //preparedStatement.setInt(11,resource.getRESOURCE_ID());
        preparedStatement.executeUpdate();
    }

    public Optional<Resource> getResource(int resourceId) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM RESOURCE WHERE Resource_Id = ?");
        preparedStatement.setInt(1,resourceId);
        resultSet = preparedStatement.executeQuery();
        Resource resource = new Resource();
        if(resultSet.next()) {
            resource.setISBN(resultSet.getInt("ISBN"));
            resource.setRESOURCE_TYPE(ResourceType.valueOf(resultSet.getString("RESOURCE_TYPE")));
            resource.setTitle(resultSet.getString("TITLE"));
            resource.setEDITION(resultSet.getString("EDITION"));
            resource.setAUTHOR(resultSet.getString("AUTHOR"));
            resource.setCATEGORY(Category.valueOf(resultSet.getString("CATEGORY")));
            resource.setPUBLISHER(resultSet.getString("PUBLISHER"));
            resource.setLANGUAGE(Language.valueOf(resultSet.getString("LANGUAGE")));
            resource.setQUANTITY(resultSet.getInt("QUANTITY"));
            resource.setDESCRIPTION(resultSet.getString("DESCRIPTION"));
            //resource.setRESOURCE_ID(resultSet.getInt("Resource_Id"));;
        }
        return Optional.of(resource);
    }

    public List<Resource> getResourcesByTitle(String resourceTitle) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM RESOURCE WHERE title like ? ");
        preparedStatement.setString(1, "%" + resourceTitle + "%");
        resultSet = preparedStatement.executeQuery();
        List<Resource> resources = new ArrayList<>();
        if(resultSet.next()) {
            Resource resource = new Resource();
            //resource.setRESOURCE_ID(resultSet.getInt("Resource_Id"));
            resource.setISBN(resultSet.getInt("ISBN"));
            resource.setRESOURCE_TYPE(ResourceType.valueOf(resultSet.getString("RESOURCE_TYPE")));
            resource.setTitle(resultSet.getString("TITLE"));
            resource.setEDITION(resultSet.getString("EDITION"));
            resource.setAUTHOR(resultSet.getString("AUTHOR"));
            resource.setCATEGORY(Category.valueOf(resultSet.getString("CATEGORY")));
            resource.setPUBLISHER(resultSet.getString("PUBLISHER"));
            resource.setLANGUAGE(Language.valueOf(resultSet.getString("LANGUAGE")));
            resource.setQUANTITY(resultSet.getInt("QUANTITY"));
            resource.setDESCRIPTION(resultSet.getString("DESCRIPTION"));
            resources.add(resource);
        }
        return resources;
    }



    public List<Resource> getAllResources() throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM RESOURCE");
        resultSet = preparedStatement.executeQuery();
        List<Resource> resources = new ArrayList<>();

        while (resultSet.next()) {
            Resource resource = Resource
                    .builder()
                    //.RESOURCE_ID(resultSet.getInt("RESOURCE_ID"))
                    .ISBN(resultSet.getInt("ISBN"))
                    .RESOURCE_TYPE(ResourceType.valueOf(resultSet.getString("RESOURCE_TYPE")))
                    .title(resultSet.getString("TITLE"))
                    .EDITION(resultSet.getString("EDITION"))
                    .AUTHOR(resultSet.getString("AUTHOR"))
                    .CATEGORY(Category.valueOf(resultSet.getString("CATEGORY")))
                    .PUBLISHER(resultSet.getString("PUBLISHER"))
                    .LANGUAGE(Language.valueOf(resultSet.getString("LANGUAGE")))
                    .QUANTITY(resultSet.getInt("QUANTITY"))
                    .DESCRIPTION(resultSet.getString("DESCRIPTION"))
                    .build();

            resources.add(resource);
        }

        return resources;
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }

}
