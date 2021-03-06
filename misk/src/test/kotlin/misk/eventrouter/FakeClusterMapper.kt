package misk.eventrouter

import javax.inject.Singleton

@Singleton
class FakeClusterMapper : ClusterMapper {
  private val mapping = mutableMapOf<List<String>, String>()

  fun setOwnerForHostList(hosts: List<String>, host: String) {
    mapping[hosts.sorted()] = host
  }

  override fun topicToHost(clusterSnapshot: ClusterSnapshot, topic: String): String {
    return mapping[clusterSnapshot.hosts.sorted()]!!
  }
}
