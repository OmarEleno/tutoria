    package com.omar.demo.dao;

    import com.omar.demo.domain.TutoradoXAsistencia;
    import com.omar.demo.domain.id.TutoradoXAsistenciaId;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.List;
    import java.util.Optional;

    public interface TutoradoXAsistenciaRepository  extends JpaRepository<TutoradoXAsistencia , TutoradoXAsistenciaId> {

        public Optional<TutoradoXAsistencia> findById(TutoradoXAsistenciaId id);

        public List<TutoradoXAsistencia> findByAsistio(Boolean asistio);

    }
