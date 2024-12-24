package com.example.marvelheroesapp;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/marvelheroesapp/RetrofitInstance;", "", "()V", "BASE_URL", "", "api", "LMarvelApiService;", "getApi", "()LMarvelApiService;", "api$delegate", "Lkotlin/Lazy;", "moshi", "Lcom/squareup/moshi/Moshi;", "kotlin.jvm.PlatformType", "app_debug"})
public final class RetrofitInstance {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String BASE_URL = "https://gateway.marvel.com:443/";
    private static final com.squareup.moshi.Moshi moshi = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy api$delegate = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.marvelheroesapp.RetrofitInstance INSTANCE = null;
    
    private RetrofitInstance() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final MarvelApiService getApi() {
        return null;
    }
}