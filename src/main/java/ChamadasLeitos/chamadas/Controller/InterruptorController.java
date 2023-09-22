package ChamadasLeitos.chamadas.Controller;


import ChamadasLeitos.chamadas.Model.Interruptor;
import ChamadasLeitos.chamadas.Repository.InterruptorRepository;
import ChamadasLeitos.chamadas.Service.InterruptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class InterruptorController {
    @Autowired
    private InterruptorService interruptorService;

    @GetMapping("/")
    public String listarInterruptores(Model model) {
        List<Interruptor> interruptores = interruptorService.listarInterruptores();
        model.addAttribute("interruptores", interruptores);
        return "index";
    }

    @PostMapping("/alterarEstado")
    public String alterarEstado(@RequestParam String interruptorNome) {
        interruptorService.alterarEstado(interruptorNome);
        return "redirect:/";
    }
}
