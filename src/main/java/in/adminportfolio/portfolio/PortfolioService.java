package in.adminportfolio.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class PortfolioService {
    private final PortfolioRepository repository;

    @Autowired
    public PortfolioService(PortfolioRepository repository) {
        this.repository = repository;
    }

    public PortfolioDto getPortfolio() {
        // Load or Create defaults
        Portfolio p = repository.findById(1L).orElseGet(() -> {
            Portfolio defaults = new Portfolio();
            defaults.setId(1L);
            defaults.setHeroName("Alex Developer");
            // ... could set other defaults here ...
            return repository.save(defaults);
        });

        // Convert Entity Columns -> Frontend Map Keys
        Map<String, String> fields = new HashMap<>();
        fields.put("hero-name", p.getHeroName());
        fields.put("hero-role", p.getHeroRole());
        fields.put("hero-summary", p.getHeroSummary());
        fields.put("hero-experience", p.getHeroExperience());
        fields.put("hero-stack", p.getHeroStack());
        fields.put("hero-location", p.getHeroLocation());
        
        fields.put("about-text", p.getAboutText());
        fields.put("about-extra", p.getAboutExtra());
        
        fields.put("exp1-period", p.getExp1Period());
        fields.put("exp1-location", p.getExp1Location());
        fields.put("exp1-title", p.getExp1Title());
        fields.put("exp1-summary", p.getExp1Summary());
        fields.put("exp1-bullets", p.getExp1Bullets());
        
        fields.put("exp2-period", p.getExp2Period());
        fields.put("exp2-location", p.getExp2Location());
        fields.put("exp2-title", p.getExp2Title());
        fields.put("exp2-summary", p.getExp2Summary());
        fields.put("exp2-bullets", p.getExp2Bullets());
        
        fields.put("proj1-title", p.getProj1Title());
        fields.put("proj1-description", p.getProj1Description());
        fields.put("proj1-tech", p.getProj1Tech());
        fields.put("proj1-role", p.getProj1Role());
        
        fields.put("proj2-title", p.getProj2Title());
        fields.put("proj2-description", p.getProj2Description());
        fields.put("proj2-tech", p.getProj2Tech());
        fields.put("proj2-role", p.getProj2Role());

        fields.put("proj3-title", p.getProj3Title());
        fields.put("proj3-description", p.getProj3Description());
        fields.put("proj3-tech", p.getProj3Tech());
        fields.put("proj3-role", p.getProj3Role());

        fields.put("skills-languages", p.getSkillsLanguages());
        fields.put("skills-frameworks", p.getSkillsFrameworks());
        fields.put("skills-infra", p.getSkillsInfra());

        fields.put("contact-text", p.getContactText());
        fields.put("contact-email", p.getContactEmail());
        fields.put("contact-linkedin", p.getContactLinkedin());

        return new PortfolioDto(fields);
    }

    public void updatePortfolio(PortfolioDto dto) {
        Map<String, String> fields = dto.fields();
        
        Portfolio p = repository.findById(1L).orElse(new Portfolio());
        p.setId(1L);

        // Map Frontend Keys -> Entity Columns
        if(fields.containsKey("hero-name")) p.setHeroName(fields.get("hero-name"));
        if(fields.containsKey("hero-role")) p.setHeroRole(fields.get("hero-role"));
        if(fields.containsKey("hero-summary")) p.setHeroSummary(fields.get("hero-summary"));
        if(fields.containsKey("hero-experience")) p.setHeroExperience(fields.get("hero-experience"));
        if(fields.containsKey("hero-stack")) p.setHeroStack(fields.get("hero-stack"));
        if(fields.containsKey("hero-location")) p.setHeroLocation(fields.get("hero-location"));

        if(fields.containsKey("about-text")) p.setAboutText(fields.get("about-text"));
        if(fields.containsKey("about-extra")) p.setAboutExtra(fields.get("about-extra"));

        if(fields.containsKey("exp1-period")) p.setExp1Period(fields.get("exp1-period"));
        if(fields.containsKey("exp1-location")) p.setExp1Location(fields.get("exp1-location"));
        if(fields.containsKey("exp1-title")) p.setExp1Title(fields.get("exp1-title"));
        if(fields.containsKey("exp1-summary")) p.setExp1Summary(fields.get("exp1-summary"));
        if(fields.containsKey("exp1-bullets")) p.setExp1Bullets(fields.get("exp1-bullets"));

        if(fields.containsKey("exp2-period")) p.setExp2Period(fields.get("exp2-period"));
        if(fields.containsKey("exp2-location")) p.setExp2Location(fields.get("exp2-location"));
        if(fields.containsKey("exp2-title")) p.setExp2Title(fields.get("exp2-title"));
        if(fields.containsKey("exp2-summary")) p.setExp2Summary(fields.get("exp2-summary"));
        if(fields.containsKey("exp2-bullets")) p.setExp2Bullets(fields.get("exp2-bullets"));

        if(fields.containsKey("proj1-title")) p.setProj1Title(fields.get("proj1-title"));
        if(fields.containsKey("proj1-description")) p.setProj1Description(fields.get("proj1-description"));
        if(fields.containsKey("proj1-tech")) p.setProj1Tech(fields.get("proj1-tech"));
        if(fields.containsKey("proj1-role")) p.setProj1Role(fields.get("proj1-role"));

        if(fields.containsKey("proj2-title")) p.setProj2Title(fields.get("proj2-title"));
        if(fields.containsKey("proj2-description")) p.setProj2Description(fields.get("proj2-description"));
        if(fields.containsKey("proj2-tech")) p.setProj2Tech(fields.get("proj2-tech"));
        if(fields.containsKey("proj2-role")) p.setProj2Role(fields.get("proj2-role"));

        if(fields.containsKey("proj3-title")) p.setProj3Title(fields.get("proj3-title"));
        if(fields.containsKey("proj3-description")) p.setProj3Description(fields.get("proj3-description"));
        if(fields.containsKey("proj3-tech")) p.setProj3Tech(fields.get("proj3-tech"));
        if(fields.containsKey("proj3-role")) p.setProj3Role(fields.get("proj3-role"));

        if(fields.containsKey("skills-languages")) p.setSkillsLanguages(fields.get("skills-languages"));
        if(fields.containsKey("skills-frameworks")) p.setSkillsFrameworks(fields.get("skills-frameworks"));
        if(fields.containsKey("skills-infra")) p.setSkillsInfra(fields.get("skills-infra"));

        if(fields.containsKey("contact-text")) p.setContactText(fields.get("contact-text"));
        if(fields.containsKey("contact-email")) p.setContactEmail(fields.get("contact-email"));
        if(fields.containsKey("contact-linkedin")) p.setContactLinkedin(fields.get("contact-linkedin"));

        repository.save(p);
    }
}