package prc391.web.rest;


import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prc391.service.dto.CartDTO;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CartResource {

    private final Logger log = LoggerFactory.getLogger(CartResource.class);

    @Autowired
    private HttpSession httpSession;

    List<CartDTO> listCart = null;

    @GetMapping("/cart")
    public void getDetailBill(@RequestParam("item") Long productID) {
        log.debug("REST request to get Add Cart");
        CartDTO cartDTO = new CartDTO(productID,Long.valueOf(1));
        if(listCart == null)
            listCart = new ArrayList<>();
        listCart.add(cartDTO);
        httpSession.setAttribute("cart",listCart);
    }

    @GetMapping("/cart/view")
    public ResponseEntity<?> viewCart() {
        log.debug("REST request to get Add Cart");
        List<CartDTO> listCart = (List<CartDTO>) httpSession.getAttribute("cart");
        return new ResponseEntity<List<CartDTO>>(listCart, HttpStatus.OK);
    }
}
