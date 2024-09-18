package tr.jafariya.jdbc_spring_first_app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import tr.jafariya.jdbc_spring_first_app.model.Book;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class BookRepository implements Repository {

    @Autowired
    private DataSource dataSource;

    public BookRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

        @Override
    public List<Book> findAllBooks() {
        List<Book> result = new ArrayList<>();
        String sql_findAllBooks = "Select * from books;";

        try (Connection c = dataSource.getConnection();
             Statement s = c.createStatement();
             ResultSet resultSet = s.executeQuery(sql_findAllBooks)) {
            while(resultSet.next()) {
                Book book = convertRowToBook(resultSet);
                result.add(book);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return result;
        }

    @Override
    public Book findByID(Long id) {
        Book result = new Book();
        String str = String.format("SELECT * FROM books WHERE id = %s;", id);
        String sql_findByID = str;

        try (Connection c = dataSource.getConnection();
             Statement s = c.createStatement();
             ResultSet resultSet = s.executeQuery(sql_findByID)) {
            while(resultSet.next()) {
                result = convertRowToBook(resultSet);

            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return result;
    }

        private Book convertRowToBook(ResultSet resultSet) throws SQLException{
            Long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            return new Book(id, name);
        }

}
