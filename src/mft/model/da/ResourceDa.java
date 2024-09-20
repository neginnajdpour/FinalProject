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
        preparedStatement = connection.prepareStatement("INSERT INTO RESOURCE(TITLE , RESOURCE_TYPE , SUBJECT , CATEGORY ,QUANTITY , ISBN ,  AUTHOR1 , EDITION , CONTENT ,PUBLISHER , LANGUAGE , SERIES , COST , AUTHOR2 , STATUS , KEYWORD) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,resource.getTITLE(resultSet.getString("TITLE")));
        preparedStatement.setString(2,resource.getRESOURCE_TYPE().name());
        preparedStatement.setString(3,resource.getSUBJECT());
        preparedStatement.setString(4,resource.getCATEGORY().name());
        preparedStatement.setInt(5,resource.getQUANTITY());
        preparedStatement.setInt(6,resource.getISBN());
        preparedStatement.setString(7,resource.getAUTHOR1());
        preparedStatement.setString(8,resource.getEDITION());
        preparedStatement.setString(9,resource.getCONTENT());
        preparedStatement.setString(10,resource.getPUBLISHER());
        preparedStatement.setString(11, resource.getLANGUAGE().name());
        preparedStatement.setInt(12, resource.getSERIES());
        preparedStatement.setInt(13, resource.getCOST());
        preparedStatement.setString(14, resource.getAUTHOR2());
        preparedStatement.setString(15, resource.getSTATUS());
        preparedStatement.setString(16, resource.getKEYWORD());
        preparedStatement.executeUpdate();

    }

    public void update(Resource resource) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("UPDATE RESOURCE SET TITLE = ? , RESOURCE_TYPE = ? , SUBJECT = ? , CATEGORY = ? , QUANTITY = ? , ISBN = ? ,  AUTHOR1 = ? , EDITION = ? , CONTENT = ? ,PUBLISHER = ? , LANGUAGE = ? , SERIES = ? , COST = ? , AUTHOR2 = ? , STATUS = ? , KEYWORD = ? WHERE ISBN = ?");
        preparedStatement.setString(1,resource.getTITLE(resultSet.getString("TITLE")));
        preparedStatement.setString(2,resource.getRESOURCE_TYPE().name());
        preparedStatement.setString(3,resource.getSUBJECT());
        preparedStatement.setString(4,resource.getCATEGORY().name());
        preparedStatement.setInt(5,resource.getQUANTITY());
        preparedStatement.setString(6,resource.getAUTHOR1());
        preparedStatement.setString(7,resource.getEDITION());
        preparedStatement.setString(8,resource.getCONTENT());
        preparedStatement.setString(9,resource.getPUBLISHER());
        preparedStatement.setString(10, resource.getLANGUAGE().name());
        preparedStatement.setInt(11, resource.getSERIES());
        preparedStatement.setInt(12, resource.getCOST());
        preparedStatement.setString(13, resource.getAUTHOR2());
        preparedStatement.setString(14, resource.getSTATUS());
        preparedStatement.setString(15, resource.getKEYWORD());
        preparedStatement.setInt(16,resource.getISBN());
        preparedStatement.executeUpdate();
    }

    public void delete(Integer ISBN) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("DELETE FROM RESOURCE WHERE ISBN = ?");
        preparedStatement.setInt(1, ISBN);
        preparedStatement.executeUpdate();
    }

    public Optional<Resource> getResource(int resourceId) throws SQLException {
        connection = JdbcProvider.getInstance().getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM RESOURCE WHERE Resource_Id = ?");
        preparedStatement.setInt(1,resourceId);
        resultSet = preparedStatement.executeQuery();
        Resource resource = new Resource();
        if(resultSet.next()) {
            resource.getTITLE(resultSet.getString("TITLE"));
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
