package altice.lab.service

import io.quarkus.cache.CacheResult
import io.smallrye.mutiny.Uni
import io.smallrye.mutiny.infrastructure.Infrastructure
import jakarta.enterprise.context.ApplicationScoped


@ApplicationScoped
class LabSeqService {

    @CacheResult(cacheName = "labSeq")
    fun getLabSeq(n: Int): Uni<Long> {
        return Uni.createFrom().item {
            calculateLabSeq(n)
        }.runSubscriptionOn(Infrastructure.getDefaultExecutor())
    }

    private fun calculateLabSeq(n: Int): Long {
        if (n <= 3) {
            return n.toLong() % 2
        }

        val cache = LongArray(n + 1)
        cache[0] = 0
        cache[1] = 1
        cache[2] = 0
        cache[3] = 1

        for (i in 4..n) {
            cache[i] = cache[i - 4] + cache[i - 3]
        }

        return cache[n]
    }

}