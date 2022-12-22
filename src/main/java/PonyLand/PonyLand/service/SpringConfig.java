package PonyLand.PonyLand.service;

import PonyLand.PonyLand.Repository.Family.FamilyRepository;
import PonyLand.PonyLand.Repository.Family.JpaFamilyRepository;
import PonyLand.PonyLand.Repository.item.ItemRepository;
import PonyLand.PonyLand.Repository.item.JpaItemRepository;
import PonyLand.PonyLand.Repository.item.SpringDataJpaItemRepository;
import PonyLand.PonyLand.Repository.member.JpaMemberRepository;
import PonyLand.PonyLand.Repository.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import java.util.Random;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberRepository memberRepository(){
        return new JpaMemberRepository(em);
    }

    @Bean
    public FamilyRepository familyRepository() {return new JpaFamilyRepository(em);}

    @Bean
    public ItemRepository itemRepository() {return new JpaItemRepository(em);
    }

    @Bean
    public Random random(){
        return new Random();
    }




}
