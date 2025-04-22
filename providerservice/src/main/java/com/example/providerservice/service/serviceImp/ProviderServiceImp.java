package com.example.providerservice.service.serviceImp;
import com.example.providerservice.dtos.request.ProviderRequest;
import com.example.providerservice.dtos.response.ProviderResponse;
import com.example.providerservice.model.Provider;
import com.example.providerservice.repository.ProviderDAO;
import com.example.providerservice.service.ProviderService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProviderServiceImp implements ProviderService {
    public static ProviderDAO providerdao;
    private final ProviderDAO providerDAO;

    public ProviderServiceImp(ProviderDAO providerdao, ProviderDAO providerDAO) {
        ProviderServiceImp.providerdao = providerdao;
        this.providerDAO = providerDAO;
    }
    @Override
    public ProviderResponse createProvider(ProviderRequest providerRequest) {
        Provider provider= ProviderResponse.toEntity(providerRequest);
        Provider savedProvider = providerdao.save(provider);
        return  ProviderResponse.fromEntity(savedProvider);
    }
    @Override
    public ProviderResponse getPovider(Long id) {
        return providerdao.findById(id).map(ProviderResponse::fromEntity).
                orElseThrow(()->new RuntimeException("Provider not found"));
    }

    @Override
    public List<ProviderResponse> getAllPriver() {
        return providerdao.findAll().stream().
                map(ProviderResponse::fromEntity).
                collect(Collectors.toList());
    }

    @Override
    public ProviderResponse updateProvider(ProviderRequest providerRequest, Long id) {

        Provider provider =providerDAO.findById(id).orElseThrow(
                ()->new RuntimeException("Provider not found with this id:"+id));
        if(provider !=null){
            Provider p = ProviderResponse.toEntity(providerRequest);
            p.setId(id);
            Provider savedProvider=providerDAO.save(p);
            return ProviderResponse.fromEntity(savedProvider);
        }else{
            return  null;
        }

    }

    @Override
    public HashMap<String, String> deleteProvider(Long id) {
        HashMap message = new HashMap<>() ;
        Provider provider=providerDAO.findById(id).orElseThrow(null);
        if(provider!=null){
            try{
                providerDAO.deleteById(id);
                message.put("Provider","provider deleted successfully");
            }catch(Exception e){
                message.put("provider",e.getMessage());
            }
        }else {
            message.put("message", "provider not found" + id);
        }
        return message;
    }
}
