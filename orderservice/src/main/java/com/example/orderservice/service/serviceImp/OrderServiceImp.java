package com.example.orderservice.service.serviceImp;
import com.example.orderservice.dtos.request.OrderRequest;
import com.example.orderservice.dtos.response.OrderResponse;
import com.example.orderservice.model.Order;
import com.example.orderservice.reposirory.OrderDAO;
import com.example.orderservice.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class OrderServiceImp implements OrderService {

    public static OrderDAO orderdao;
    //private final ClientDAO clientDAO;
    //private final DriverDAO driverDAO;

    public OrderServiceImp (OrderDAO orderdao) {
        OrderServiceImp.orderdao = orderdao;
       // this.clientDAO = clientDAO;
       // this.driverDAO = driverDAO;
    }
    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        Order order = OrderResponse.toEntity(orderRequest);
        Order orderSaved= orderdao.save(order);
        return OrderResponse.fromEntity(orderSaved);

    }

    @Override
    public OrderResponse getOrder(Long id) {
        return orderdao.findById(id).
                map(OrderResponse::fromEntity).
                orElseThrow(()->new RuntimeException("order not found"));
    }

    @Override
    public List<OrderResponse> getAllOrder() {
        return orderdao.findAll().stream().
                map(OrderResponse::fromEntity).collect(Collectors.toList());
    }

    @Override
    public OrderResponse upDateOrder( OrderRequest orderRequest,  Long id) {
        Order order =orderdao.findById(id).orElseThrow(
                ()->new RuntimeException("order not found with this id:"+id));
        if(order !=null){
            Order o = OrderResponse.toEntity(orderRequest);
            o.setId(id);
            Order savedOrder=orderdao.save(o);
            return OrderResponse.fromEntity(savedOrder);
        }else{
            return  null;
        }

    }

    @Override
    public HashMap<String, String> deleteOrder(Long id) {
        HashMap message = new HashMap<>() ;
        Order order=orderdao.findById(id).orElseThrow(null);
        if(order!=null){
            try{
                orderdao.deleteById(id);
                message.put("Order","Order deleted successfully");
            }catch(Exception e){
                message.put("Order",e.getMessage());
            }
        }else {
            message.put("message", "Order not found" + id);
        }
        return message;
    }

    @Override
    public OrderResponse createOrderWithClientAndDriver(OrderRequest orderRequest, Long clientId,Long driverId) {
       // Client client = clientDAO.findById(clientId).orElseThrow(() -> new RuntimeException("client not found"));
        Order order = OrderResponse.toEntity(orderRequest);
       // order.setClient(client);
       // Driver driver = driverDAO.findById(driverId).orElseThrow(() -> new RuntimeException("driver not found"));
        //order.setDriver(driver);
        Order savedOrder = orderdao.save(order);
        return OrderResponse.fromEntity(savedOrder);
//        @Override
//        public OrderResponse saveOrder(OrderRequest orderRequest, Long clientId, List<Integer> productIds) {
//            List<String> messages = new ArrayList<>();
//
//            for (int productId : productIds) {
//                Product product = productDao.findById(productId).orElse(null);
//
//                if (product != null) {
        // Update product and add it to the order
//                    product.setNbreOrder(product.getNbreOrder() + 1);
//                    product.setQte_en_stock(product.getQte_en_stock() - 1); // Decrement stock quantity

        // Check if the quantity is low and add a warning message
//                    if (product.getQte_en_stock() < 20) {
//                        String message = "Le produit " + product.getName()
//                                + " a une quantité faible dans le stock ! Il en reste seulement "
//                                + product.getQte_en_stock();
//                        messages.add(message);
//                    }
//
//                    orderRequest.addproduct(product);
//                }
//            }
//
//            Customer customer = clientDao.findById(clientId).orElseThrow(()->
//
//                    new IllegalArgumentException("Client not found with ID: " + clientId));
//
//
//            Order order = OrderResponse.toEntity(orderRequest);
//            order.setCustomer(customer);
//            order.setMessages(messages);
//
//            Order savedOrder = orderDaoconst.save(order);
//            return OrderResponse.fromEntity(savedOrder);
//        }
//        @Transactional
//        @Override
//        public OrderResponse passerOrder(OrderRequest orderRequest, Long customer_id) {
        // Find the customer
//            Customer customer = clientDao.findById(customer_id)
//                    .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        // Find the active panier
//            Panier activePanier = panierDao.findActivePanier()
//                    .orElseThrow(() -> new RuntimeException("Aucun panier actif trouvé"));

        // Check if an order already exists for this active panier
//            if (orderDao.existsByPanierId(activePanier.getId())) {
//                throw new IllegalArgumentException("Le panier a déjà une commande associée.");
//            }

        // Create a new order
//            Order order = new Order();
//            order.setCustomer(customer);
//            order.setPanier(activePanier);  // Associate the order with the active panier

        // Mettre à jour les quantités des produits en stock
//            List<Product> products = activePanier.getProducts();
//            for (Product product : products) {
//                int quantityInStock = product.getQte_en_stock();
//                int quantityOrdered = product.getQte_user();
//
//                if (quantityInStock < quantityOrdered) {
//                    throw new IllegalArgumentException("Quantité insuffisante pour le produit : " + product.getName());
//                }

        // Diminuer la quantité en stock
//                product.setQte_en_stock(quantityInStock - quantityOrdered);
//                productDao.save(product); // Enregistrer les modifications
//            }

        // Compléter la commande avec les informations restantes
//            order.setPrice_total(activePanier.getPricetotaltotal());
//            order.setQte_total(activePanier.getQteTotal());
//
//            // Save the order
//            Order savedOrder = orderDao.save(order);
//
//            // Deactivate the old active panier
//            panierDao.deactivatePanierById(activePanier.getId());
//
//            // Create a new empty panier
//            Panier newPanier = new Panier();
//            newPanier.setIsActive(true);
//
//            // Debugging output to verify state before saving
//            System.out.println("Saving new empty panier with active status: " + newPanier.isActive());
//
//            panierDao.save(newPanier);  // Save the new empty panier
//
//            return OrderResponse.fromEntity(savedOrder);  // Return the response
//        }
//    }

    }
}
