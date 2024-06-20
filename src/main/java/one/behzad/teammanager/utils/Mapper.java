package one.behzad.teammanager.utils;

import lombok.Getter;
import one.behzad.teammanager.DTOs.MemberDTO;
import one.behzad.teammanager.DTOs.TeamDTO;
import one.behzad.teammanager.models.Member;
import one.behzad.teammanager.models.Team;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Mapper {
    private static Mapper MAPPER;
    private static ModelMapper modelMapper;

    private Mapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        modelMapper.typeMap(Team.class, TeamDTO.class)
                .addMappings(mapper -> mapper.using(this.getMemberToMemberDTOConverter())
                        .map(Team::getMembers, TeamDTO::setMemberDTOs));
        modelMapper.typeMap(TeamDTO.class, Team.class)
                .addMappings(mapper -> mapper.using(this.getMemberDTOtoMemberConverter())
                        .map(TeamDTO::getMemberDTOs, Team::setMembers));
    }

    public static ModelMapper getMapper() {
        if (MAPPER == null) {
            MAPPER = new Mapper();
        }
        return modelMapper;
    }

    public static List<MemberDTO> membersToMembersDTO(List<Member> members) {
        List<MemberDTO> memberDTOS = new ArrayList<>();

        for (Member member : members) {
            MemberDTO memberDTO = getMapper().map(member, MemberDTO.class);
            memberDTOS.add(memberDTO);
        }
        return memberDTOS;
    }

    // TODO go for generics
    private AbstractConverter<List<Member>, List<MemberDTO>> getMemberToMemberDTOConverter() {
        return new AbstractConverter<>() {
            @Override
            protected List<MemberDTO> convert(List<Member> members) {
                return members.stream().map(member -> modelMapper.map(member, MemberDTO.class))
                        .toList();
            }
        };
    }

    private AbstractConverter<List<MemberDTO>, List<Member>> getMemberDTOtoMemberConverter() {
        return new AbstractConverter<>() {
            @Override
            protected List<Member> convert(List<MemberDTO> memberDTOs) {
                return memberDTOs.stream().map(member -> modelMapper.map(member, Member.class))
                        .toList();
            }
        };
    }
}
