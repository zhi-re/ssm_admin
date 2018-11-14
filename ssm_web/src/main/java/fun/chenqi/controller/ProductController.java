package fun.chenqi.controller;

import com.github.pagehelper.PageInfo;
import fun.chenqi.domain.Product;
import fun.chenqi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.beans.PropertyEditor;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
@Secured("ROLE_ADMIN") // 针对访问的url路径做请求验证的权限控制 security注解
//  @RolesAllowed("ROLE_ADMIN") jsr-250注解
//  @PreAuthorize("hasRole('ROLE_ADMIN')") 支持表达式注解
public class ProductController {
    @Autowired
    private IProductService service;

    // 查询所有旅游路线
    @RequestMapping("/findAllProduct")
    public String findAll(Model model) throws Exception {
        List<Product> list = service.findAll();
        model.addAttribute("productList", list);
        return "product-list";
    }


    // 查询所有的路线带分页 使用pageHelper的方式
    // RequestParam注解实现参数绑定
    // value：请求参数中的名称。
    // defaultValue：默认值
    // required：请求参数中是否必须提供此参数。默认值：true。表示必须提供，如果不提供将报错。
    @RequestMapping("/findByPageHelper")
    public String findByPageHelper(
            @RequestParam(required = true, defaultValue = "1") int pageNum, // pageNum当前页数 pageSize每页显示数据
            @RequestParam(required = true, defaultValue = "5") int pageSize, Model model) throws Exception {
        // 分页查询
        PageInfo page = service.findByPageHelper(pageNum, pageSize);
        model.addAttribute("page", page);
        return "product-list";
    }


    // 保存路线
    @RequestMapping("/save")
    public String save(Product product) {
        service.save(product);
        return "redirect:/product/findByPageHelper";
    }


    // 按ID查找路线
    @RequestMapping("/findProductById")
    public String findProductById(Long id, Model model) {
        Product product = service.findProductByid(id);
        model.addAttribute("product", product);
        return "product-update";
    }


    // 更新路线
    @RequestMapping("/update")
    public String update(Product product) {
        System.out.println(product);
        service.update(product);
        return "redirect:/product/findAllProduct";
    }

    // 删除路线
    @RequestMapping("/deleteById")
    public String deleteById(Long id) {
        // System.out.println(id);
        service.deleteById(id);
        return "redirect:/product/findAllProduct";
    }

}
