package com.abatalib.apifamilleemploi.repository;

import com.abatalib.apifamilleemploi.models.Famille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilleRepo extends JpaRepository<Famille,Long>  {
    @Query(
            value = "SELECT * FROM t_famille_emploi f WHERE f.LIB_FAMILLE_EMPLOI = ?1 or f.BK_COLOR_FAMILLE_EMPLOI = ?2 or f.REF_COMPETENCE_FAMILLE_EMPLOI = ?3 LIMIT 1",
            nativeQuery = true)
//    String sql = "SELECT COUNT(*) FROM CustomerData " +
//            "WHERE custId = :custId AND deptId = :deptId";
//        Query query = session.createQuery(sql);
//    query.setParameter("custId", custId);
//    query.setParameter("deptId", deptId);
//            query.setMaxResults(1).uniqueResult();
    Famille findDouble(String LIB_FAMILLE_EMPLOI, String BK_COLOR_FAMILLE_EMPLOI, String REF_COMPETENCE_FAMILLE_EMPLOI);
}
