package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Buyer;
import ar.edu.itba.paw.models.Purchase;
import ar.edu.itba.paw.models.Vinyl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class PurchaseDaoImpl implements PurchaseDao {
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;
    private static final RowMapper<Purchase> ROW_MAPPER =
            (rs, rowNum) -> new Purchase(
                    rs.getLong("id"),
                    rs.getLong("buyerid"),
                    rs.getLong("vinylid"),
                    rs.getString("status"),
                    rs.getInt("price"),
                    rs.getDate("createdat"),
                    rs.getDate("paidat"),
                    rs.getDate("paymentreceivedat"),
                    rs.getDate("sentat"),
                    rs.getDate("deliveredat")
            );

    @Autowired
    public PurchaseDaoImpl(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .usingGeneratedKeyColumns("id")
                .withTableName("purchase");
    }
//    paw.public.purchase.id
//    paw.public.purchase.buyerid
//    paw.public.purchase.vinylid
//    paw.public.purchase.status
//    paw.public.purchase.price
//    paw.public.purchase.createdat
//    paw.public.purchase.paidat
//    paw.public.purchase.paymentreceivedat
//    paw.public.purchase.sentat
//    paw.public.purchase.deliveredat
    @Override
    public Purchase create(long buyerId, long vinylId, String status, float price) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("buyerid", buyerId);
        parameters.put("vinylid", vinylId);
        parameters.put("status", status);
        parameters.put("price", price);
        parameters.put("createdat", new java.sql.Date(System.currentTimeMillis()));
        parameters.put("paidat", null);
        parameters.put("paymentreceivedat", null);
        parameters.put("sentat", null);
        parameters.put("deliveredat", null);
        Number id = jdbcInsert.executeAndReturnKey(parameters);
        return new Purchase(id.longValue(), buyerId, vinylId, status, price,
                new java.sql.Date(System.currentTimeMillis()), null, null, null, null);
    }

    @Override
    public Optional<Purchase> findById(long id) {
        return jdbcTemplate.query("SELECT * FROM purchase WHERE id = ?", ROW_MAPPER, id)
                .stream()
                .findFirst();
    }
}
