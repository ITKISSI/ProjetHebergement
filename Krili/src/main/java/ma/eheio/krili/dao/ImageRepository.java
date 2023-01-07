package ma.eheio.krili.dao;

import ma.eheio.krili.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image,Long> {
    List<Image> findImageByAnnonce(Long Id);
}
