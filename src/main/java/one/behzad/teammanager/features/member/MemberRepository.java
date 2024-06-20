package one.behzad.teammanager.features.member;

import jakarta.annotation.Nonnull;
import one.behzad.teammanager.models.Member;
import one.behzad.teammanager.models.Stroke;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {

    @Override
    @Nonnull
    List<Member> findAll();

    // TODO: to test
    List<Member> findAllByMainStrokeFirst(Stroke stroke);

    // TODO: to test
    List<Member> findAllByMainStrokeIsIMSwimmer(boolean isIMSwimmer);
}
