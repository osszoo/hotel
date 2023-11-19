package kr.ac.mjc.hotel.controller;

import kr.ac.mjc.hotel.model.InquiryForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

    @GetMapping
    public String showInquiryForm(Model model) {
        model.addAttribute("inquiryForm", new InquiryForm());
        return "inquiry";
    }

    @PostMapping("/submit")
    public String submitInquiry(
            @RequestParam String questionType,
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam(required = false) boolean agree,
            Model model) {
        // 여기서 동의 여부(agree)에 따른 로직을 추가할 수 있습니다.
        // 동의한 경우에만 데이터를 저장하도록 구현할 수 있습니다.
        if (agree) {
            // 동의한 경우의 로직을 추가하세요.
        } else {
            model.addAttribute("error", "개인정보 수집 및 이용에 동의해야 합니다.");
            return "inquiry";
        }

        // 나머지 로직을 추가하세요.
        return "redirect:/inquiry/success";
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }
}
