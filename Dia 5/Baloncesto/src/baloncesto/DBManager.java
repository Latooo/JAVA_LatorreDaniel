package baloncesto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
    private static final String URL = "jdbc:mysql://uwry5oyyq3ugwcjs:iyWWUlt9POHoMniomzBr@bfkhguovcbykwama3z23-mysql.services.clever-cloud.com:3306/bfkhguovcbykwama3z23";
    private static final String USER = "uwry5oyyq3ugwcjs";
    private static final String PASSWORD = "iyWWUlt9POHoMniomzBr";

    public Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            return null;
        }
    }

    public void addPartido(Partido partido) {
        String sql = "INSERT INTO Partidos (fecha, equipo_local, equipo_visitante, finalizado) VALUES (?, ?, ?, ?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, java.sql.Date.valueOf(partido.getFecha()));
            pstmt.setString(2, partido.getEquipoLocal());
            pstmt.setString(3, partido.getEquipoVisitante());
            pstmt.setBoolean(4, partido.isFinalizado());
            pstmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void addLiga(int partidoId, int cestasLocal, int cestasVisitante) {
        String sql = "INSERT INTO Liga (partido_id, cestas_local, cestas_visitante) VALUES (?, ?, ?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, partidoId);
            pstmt.setInt(2, cestasLocal);
            pstmt.setInt(3, cestasVisitante);
            pstmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void addPlayoff(int partidoId, int cestasLocal, int cestasVisitante) {
        String sql = "INSERT INTO Playoff (partido_id, cestas_local, cestas_visitante) VALUES (?, ?, ?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, partidoId);
            pstmt.setInt(2, cestasLocal);
            pstmt.setInt(3, cestasVisitante);
            pstmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void listPartidos() {
        String sql = "SELECT * FROM Partidos";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + 
                                   ", Fecha: " + rs.getDate("fecha") +
                                   ", Local: " + rs.getString("equipo_local") + 
                                   ", Visitante: " + rs.getString("equipo_visitante") +
                                   ", Finalizado: " + rs.getBoolean("finalizado"));
            }
        } catch (SQLException e) {
        }
    }
}

