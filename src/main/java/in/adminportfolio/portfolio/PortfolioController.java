package in.adminportfolio.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {
	private final PortfolioService portfolioService;

    @Autowired
    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping
    public PortfolioDto getPortfolio() {
        return portfolioService.getPortfolio();
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void updatePortfolio(@RequestBody PortfolioDto dto) {
        portfolioService.updatePortfolio(dto);
    }
}
