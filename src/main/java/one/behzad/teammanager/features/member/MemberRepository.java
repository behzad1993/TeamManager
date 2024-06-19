package one.behzad.teammanager.features.member;

import one.behzad.teammanager.models.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {

    @Override
    List<Member> findAll();

    // TODO: to test
//    List<Member> findAllByMainStrokeFirst(Stroke stroke);

    // TODO: to test
//    List<Member> findAllByMainStrokeIsIMSwimmer(boolean isIMSwimmer);
}
