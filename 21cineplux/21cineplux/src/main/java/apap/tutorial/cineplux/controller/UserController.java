package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.service.RoleService;
import apap.tutorial.cineplux.service.UserService;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    private String addUserFormPage(Model model) {
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value = "/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model) {
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    // latihan 1 - tutorial 6
    @GetMapping(value = "/viewall")
    public String viewAllUser (
            Model model
    ){
        model.addAttribute("listUser", userService.getListUser());
        return "viewall-user";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(
            @PathVariable String username,
            Model model
    ) {
        UserModel user = userService.getUserByUsername(username);
        userService.deleteUser(user);
        model.addAttribute("listUser", userService.getListUser());
        return "viewall-user";
    }

    // latihan no 4 - tutorial 6
    @GetMapping(value = "/update-password")
    private String updatePasswordForm(Model model) {
        return "form-update-password";
    }

    @PostMapping(value = "/update-password")
    private String updatePasswordSubmit(
            @RequestParam String passwordLama,
            String passwordBaru,
            String passwordBaru2,
            String username,
            Model model) {
        UserModel user = userService.getUserByUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (encoder.matches(passwordLama, user.getPassword())) {
            if (passwordBaru.equals(passwordBaru2)) {
                userService.updatePassword(user, passwordBaru);
                model.addAttribute("hasil", "Password berhasil diubah!");
            } else {
                model.addAttribute("hasil", "Password gagal diubah!");
            }
        }

        return "form-update-password";
    }

}
