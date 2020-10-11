package br.com.docket.registry.service;

import br.com.docket.registry.model.Certificate;
import br.com.docket.registry.service.stub.Certidao;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DocketCertificateService {

     public List<Certificate> fetchCertificates() throws IOException {

         Retrofit retrofit = new Retrofit.Builder()
                 .baseUrl("https://docketdesafiobackend.herokuapp.com")
                 .addConverterFactory(JacksonConverterFactory.create())
                 .build();


         DocketService docketService = retrofit.create(DocketService.class);
         Call<List<Certidao>> certidoes = docketService.listRepos();
         Response<List<Certidao>> listResponse = certidoes.execute();
         List<Certidao> certificadosList = listResponse.body();
         Stream<Certificate> certificateStream = certificadosList.stream().map(Certidao::convertToCertificate);
         List<Certificate> certificateList = certificateStream.collect(Collectors.toList());
         return certificateList;
     }

}
