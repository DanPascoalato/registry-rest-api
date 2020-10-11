package br.com.docket.registry.service;

import br.com.docket.registry.service.stub.Certidao;
import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface DocketService {
        @GET("/api/v1/certidoes")
        Call<List<Certidao>> listRepos();
}
