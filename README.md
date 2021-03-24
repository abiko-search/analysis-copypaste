# CopyPaste

A simple plugin for Elasticsearch for filtering out duplicate text

## Setup

```bash
./bin/elasticsearch-plugin install https://github.com/abiko-search/analysis-copypaste/releases/download/v1.0.0/analysis-copypaste-1.0.0.zip
```

## Usage

```
GET /_analyze?pretty=true
{
  "tokenizer": "standard",
  "filter": ["copypaste"],
  "text": "So I repeat every sentence twice. So I repeat every sentence twice. That is dumb."
}
```

The request returns the following result:

```json
{
  "tokens" : [
    {
      "token" : "So",
      "start_offset" : 0,
      "end_offset" : 2,
      "type" : "<ALPHANUM>",
      "position" : 0
    },
    {
      "token" : "I",
      "start_offset" : 3,
      "end_offset" : 4,
      "type" : "<ALPHANUM>",
      "position" : 1
    },
    {
      "token" : "repeat",
      "start_offset" : 5,
      "end_offset" : 11,
      "type" : "<ALPHANUM>",
      "position" : 2
    },
    {
      "token" : "every",
      "start_offset" : 12,
      "end_offset" : 17,
      "type" : "<ALPHANUM>",
      "position" : 3
    },
    {
      "token" : "sentence",
      "start_offset" : 18,
      "end_offset" : 26,
      "type" : "<ALPHANUM>",
      "position" : 4
    },
    {
      "token" : "twice",
      "start_offset" : 27,
      "end_offset" : 32,
      "type" : "<ALPHANUM>",
      "position" : 5
    },
    {
      "token" : "That",
      "start_offset" : 68,
      "end_offset" : 72,
      "type" : "<ALPHANUM>",
      "position" : 12
    },
    {
      "token" : "is",
      "start_offset" : 73,
      "end_offset" : 75,
      "type" : "<ALPHANUM>",
      "position" : 13
    },
    {
      "token" : "dumb",
      "start_offset" : 76,
      "end_offset" : 80,
      "type" : "<ALPHANUM>",
      "position" : 14
    }
  ]
}
```

## Derivation

**CopyPaste** is a derivative work from Elasticsearch [DeDuplicatingTokenFilter](https://github.com/elastic/elasticsearch/blob/v7.2.0/server/src/main/java/org/apache/lucene/analysis/miscellaneous/DeDuplicatingTokenFilter.java)

## License

[Apache 2.0] © [Danila Poyarkov]

[Apache 2.0]: LICENSE
[Danila Poyarkov]: http://dannote.net
