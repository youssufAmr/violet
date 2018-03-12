package jonamatoka.violet.web.pages;

import jonamatoka.violet.Lib;
import jonamatoka.violet.account.User;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MiscPages {

    @RequestMapping(value = Lib.Mappings.ROOT, method = RequestMethod.GET)
    public String index(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("name", ((User)auth.getPrincipal()).getUsername());
        model.addAttribute("priv", auth.getAuthorities());

        return Lib.Templates.INDEX;

    }

    @RequestMapping(value = Lib.Mappings.ROOT, method = RequestMethod.POST, params = "btnLogout")
    public String btnLogout() {

        return "redirect:" + Lib.Mappings.LOGOUT;

    }

    @RequestMapping(value = Lib.Mappings.ROOT, method = RequestMethod.POST, params = "btnViewStores")
    public String btnViewStores() {

        return "redirect:" + Lib.Mappings.VIEW_SYSTEM_STORES;

    }
}
