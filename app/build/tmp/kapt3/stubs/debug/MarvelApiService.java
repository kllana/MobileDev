
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J?\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ5\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"LMarvelApiService;", "", "getCharacterById", "Lretrofit2/Response;", "Lcom/example/marvelheroesapp/classes/ApiResponse;", "characterId", "", "apiKey", "", "ts", "hash", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCharacters", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface MarvelApiService {
    
    @retrofit2.http.GET(value = "v1/public/characters")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCharacters(@retrofit2.http.Query(value = "apikey")
    @org.jetbrains.annotations.NotNull
    java.lang.String apiKey, @retrofit2.http.Query(value = "ts")
    @org.jetbrains.annotations.NotNull
    java.lang.String ts, @retrofit2.http.Query(value = "hash")
    @org.jetbrains.annotations.NotNull
    java.lang.String hash, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.marvelheroesapp.classes.ApiResponse>> $completion);
    
    @retrofit2.http.GET(value = "v1/public/characters/{characterId}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCharacterById(@retrofit2.http.Path(value = "characterId")
    int characterId, @retrofit2.http.Query(value = "apikey")
    @org.jetbrains.annotations.NotNull
    java.lang.String apiKey, @retrofit2.http.Query(value = "ts")
    @org.jetbrains.annotations.NotNull
    java.lang.String ts, @retrofit2.http.Query(value = "hash")
    @org.jetbrains.annotations.NotNull
    java.lang.String hash, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.marvelheroesapp.classes.ApiResponse>> $completion);
}