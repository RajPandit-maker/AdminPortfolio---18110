package in.adminportfolio.portfolio;

import jakarta.persistence.*;

@Entity
@Table(name = "portfolio")
public class Portfolio {
    @Id
    private Long id;

    // --- Hero Section ---
    @Column(name = "hero_name") private String heroName;
    @Column(name = "hero_role") private String heroRole;
    @Column(name = "hero_summary", columnDefinition = "TEXT") private String heroSummary;
    @Column(name = "hero_experience") private String heroExperience;
    @Column(name = "hero_stack") private String heroStack;
    @Column(name = "hero_location") private String heroLocation;

    // --- About Section ---
    @Column(name = "about_text", columnDefinition = "TEXT") private String aboutText;
    @Column(name = "about_extra", columnDefinition = "TEXT") private String aboutExtra;

    // --- Experience 1 ---
    @Column(name = "exp1_period") private String exp1Period;
    @Column(name = "exp1_location") private String exp1Location;
    @Column(name = "exp1_title") private String exp1Title;
    @Column(name = "exp1_summary", columnDefinition = "TEXT") private String exp1Summary;
    @Column(name = "exp1_bullets", columnDefinition = "TEXT") private String exp1Bullets;

    // --- Experience 2 ---
    @Column(name = "exp2_period") private String exp2Period;
    @Column(name = "exp2_location") private String exp2Location;
    @Column(name = "exp2_title") private String exp2Title;
    @Column(name = "exp2_summary", columnDefinition = "TEXT") private String exp2Summary;
    @Column(name = "exp2_bullets", columnDefinition = "TEXT") private String exp2Bullets;

    // --- Projects ---
    @Column(name = "proj1_title") private String proj1Title;
    @Column(name = "proj1_desc", columnDefinition = "TEXT") private String proj1Description;
    @Column(name = "proj1_tech") private String proj1Tech;
    @Column(name = "proj1_role") private String proj1Role;

    @Column(name = "proj2_title") private String proj2Title;
    @Column(name = "proj2_desc", columnDefinition = "TEXT") private String proj2Description;
    @Column(name = "proj2_tech") private String proj2Tech;
    @Column(name = "proj2_role") private String proj2Role;

    @Column(name = "proj3_title") private String proj3Title;
    @Column(name = "proj3_desc", columnDefinition = "TEXT") private String proj3Description;
    @Column(name = "proj3_tech") private String proj3Tech;
    @Column(name = "proj3_role") private String proj3Role;

    // --- Skills ---
    @Column(name = "skills_languages", columnDefinition = "TEXT") private String skillsLanguages;
    @Column(name = "skills_frameworks", columnDefinition = "TEXT") private String skillsFrameworks;
    @Column(name = "skills_infra", columnDefinition = "TEXT") private String skillsInfra;

    // --- Contact ---
    @Column(name = "contact_text", columnDefinition = "TEXT") private String contactText;
    @Column(name = "contact_email") private String contactEmail;
    @Column(name = "contact_linkedin") private String contactLinkedin;

    // Getters and Setters for ALL fields (Required for Hibernate)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getHeroName() { return heroName; }
    public void setHeroName(String heroName) { this.heroName = heroName; }
    public String getHeroRole() { return heroRole; }
    public void setHeroRole(String heroRole) { this.heroRole = heroRole; }
    public String getHeroSummary() { return heroSummary; }
    public void setHeroSummary(String heroSummary) { this.heroSummary = heroSummary; }
    // ... (Generate Getters/Setters for the rest in your IDE) ...
    
    // For brevity in this guide, assume all Getters/Setters exist below
    
    // -- EXP 1 --
    public void setExp1Period(String s) { this.exp1Period = s; } public String getExp1Period() { return exp1Period; }
    public void setExp1Location(String s) { this.exp1Location = s; } public String getExp1Location() { return exp1Location; }
    public void setExp1Title(String s) { this.exp1Title = s; } public String getExp1Title() { return exp1Title; }
    public void setExp1Summary(String s) { this.exp1Summary = s; } public String getExp1Summary() { return exp1Summary; }
    public void setExp1Bullets(String s) { this.exp1Bullets = s; } public String getExp1Bullets() { return exp1Bullets; }

    // -- EXP 2 --
    public void setExp2Period(String s) { this.exp2Period = s; } public String getExp2Period() { return exp2Period; }
    public void setExp2Location(String s) { this.exp2Location = s; } public String getExp2Location() { return exp2Location; }
    public void setExp2Title(String s) { this.exp2Title = s; } public String getExp2Title() { return exp2Title; }
    public void setExp2Summary(String s) { this.exp2Summary = s; } public String getExp2Summary() { return exp2Summary; }
    public void setExp2Bullets(String s) { this.exp2Bullets = s; } public String getExp2Bullets() { return exp2Bullets; }

    // ... (Similarly for Projects, Skills, Contact, Hero extras) ...
    // IMPORTANT: In your real file, generate ALL Getters and Setters.
    
    // [Helper for Service]
    // You can keep it clean by using direct field access in Service if in same package,
    // or generate full boilerplate.
    public String getHeroExperience() { return heroExperience; } public void setHeroExperience(String s) { this.heroExperience = s; }
    public String getHeroStack() { return heroStack; } public void setHeroStack(String s) { this.heroStack = s; }
    public String getHeroLocation() { return heroLocation; } public void setHeroLocation(String s) { this.heroLocation = s; }
    public String getAboutText() { return aboutText; } public void setAboutText(String s) { this.aboutText = s; }
    public String getAboutExtra() { return aboutExtra; } public void setAboutExtra(String s) { this.aboutExtra = s; }
    
    public String getProj1Title() { return proj1Title; } public void setProj1Title(String s) { this.proj1Title = s; }
    public String getProj1Description() { return proj1Description; } public void setProj1Description(String s) { this.proj1Description = s; }
    public String getProj1Tech() { return proj1Tech; } public void setProj1Tech(String s) { this.proj1Tech = s; }
    public String getProj1Role() { return proj1Role; } public void setProj1Role(String s) { this.proj1Role = s; }
    
    public String getProj2Title() { return proj2Title; } public void setProj2Title(String s) { this.proj2Title = s; }
    public String getProj2Description() { return proj2Description; } public void setProj2Description(String s) { this.proj2Description = s; }
    public String getProj2Tech() { return proj2Tech; } public void setProj2Tech(String s) { this.proj2Tech = s; }
    public String getProj2Role() { return proj2Role; } public void setProj2Role(String s) { this.proj2Role = s; }

    public String getProj3Title() { return proj3Title; } public void setProj3Title(String s) { this.proj3Title = s; }
    public String getProj3Description() { return proj3Description; } public void setProj3Description(String s) { this.proj3Description = s; }
    public String getProj3Tech() { return proj3Tech; } public void setProj3Tech(String s) { this.proj3Tech = s; }
    public String getProj3Role() { return proj3Role; } public void setProj3Role(String s) { this.proj3Role = s; }

    public String getSkillsLanguages() { return skillsLanguages; } public void setSkillsLanguages(String s) { this.skillsLanguages = s; }
    public String getSkillsFrameworks() { return skillsFrameworks; } public void setSkillsFrameworks(String s) { this.skillsFrameworks = s; }
    public String getSkillsInfra() { return skillsInfra; } public void setSkillsInfra(String s) { this.skillsInfra = s; }

    public String getContactText() { return contactText; } public void setContactText(String s) { this.contactText = s; }
    public String getContactEmail() { return contactEmail; } public void setContactEmail(String s) { this.contactEmail = s; }
    public String getContactLinkedin() { return contactLinkedin; } public void setContactLinkedin(String s) { this.contactLinkedin = s; }
    
}