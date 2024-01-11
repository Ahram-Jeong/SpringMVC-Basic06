package hello.login.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>(); // static 사용
    private static long sequence = 0L; // static 사용

    public Member save(Member member) {
        member.setId(++sequence);
        log.info("save : member = {}", member);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public Optional<Member> findByLongId(String loginId) {
        /*
        * List<Member> all = findAll();
        *
        * for (Member m : all) {
        *   if (m.getLoginId().equals(loginId)) {
        *       return Optional.of(m);
        *   }
        * }
        *
        * return Optional.empty();
        * */

        return findAll().stream() // Member list를 stream으로 바꾸어 루프를 돈다
                .filter(m -> m.getLoginId().equals(loginId)) // -> 해당 조건에 만족하는 결과들만 필터링하여 다음 단계로
                .findFirst();
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // key가 id가 되며, Member가 list로 변환 됨
    }

    public void clearStore() {
        store.clear();
    }
}
